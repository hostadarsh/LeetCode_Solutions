// class Solution 
// {
//     static class Node 
//     {
//         Map<String, Node> children = new HashMap<>();
//         boolean del = false;
//     }

//     Map<String, List<Node>> seen = new HashMap<>();

//     public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) 
//     {
//         Node root = new Node();

//         // Step 1: Build the folder tree (Trie)
//         for (List<String> path : paths) 
//         {
//             Node cur = root;
//             for (String dir : path) 
//             {
//                 cur.children.putIfAbsent(dir, new Node());
//                 cur = cur.children.get(dir);
//             }
//         }

//         // Step 2: Serialize each subtree
//         dfs(root);

//         // Step 3: Mark duplicate subtrees
//         for (List<Node> group : seen.values()) 
//         {
//             if (group.size() > 1) 
//             {
//                 for (Node node : group) 
//                 {
//                     node.del = true;
//                 }
//             }
//         }

//         // Step 4: Collect non-duplicate folder paths
//         List<List<String>> res = new ArrayList<>();
//         List<String> path = new ArrayList<>();
//         collect(root, path, res);
//         return res;
//     }

//     public String dfs(Node node) 
//     {
//         if (node.children.isEmpty())
//         {
//             return "";
//         } 

//         List<String> subs = new ArrayList<>();
//         for (String name : node.children.keySet()) 
//         {
//             String childSerial = dfs(node.children.get(name));
//             subs.add(name + "(" + childSerial + ")");
//         }

//         Collections.sort(subs);
//         String serial = String.join("", subs);
//         seen.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);

//         return serial;
//     }

//     public void collect(Node node, List<String> path, List<List<String>> res) 
//     {
//         for (Map.Entry<String, Node> entry : node.children.entrySet()) 
//         {
//             if (entry.getValue().del)
//             {
//                 continue;
//             } 

//             path.add(entry.getKey());
//             res.add(new ArrayList<>(path));
//             collect(entry.getValue(), path, res);
//             path.remove(path.size() - 1);
//         }
//     }
// }

class Solution {
    class Node {
        Map<String, Node> subNodes = new TreeMap<>();

        String content = "";

        boolean remove = false;

        void markRemove() {
            if (remove) {
                return;
            }
            remove = true;
            if (subNodes != null) {
                for (Node value : subNodes.values()) {
                    value.markRemove();
                }
            }
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        paths.sort(Comparator.comparingInt(List::size));
        List<Node> nodes = new ArrayList<>(paths.size());
        Node rootNode = new Node();
        for (List<String> pathList : paths) {
            Node current = rootNode;
            int last = pathList.size() - 1;
            for (int i = 0; i < last; i++) {
                String s = pathList.get(i);
                current = current.subNodes.get(s);
            }
            String name = pathList.get(last);
            Node node = new Node();
            current.subNodes.put(name, node);
            nodes.add(node);
        }
        StringBuilder content = new StringBuilder();
        Map<String, Node> nodeByContent = new HashMap<>();
        for (int i = nodes.size() - 1; i >= 0; i--) {
            Node node = nodes.get(i);
            if (node.subNodes.isEmpty()) {
                continue;
            }
            for (Map.Entry<String, Node> entry : node.subNodes.entrySet()) {
                content.append(entry.getKey()).append('{').append(entry.getValue().content).append('}');
            }
            node.content = content.toString();
            content.delete(0, content.length());
            Node similar = nodeByContent.putIfAbsent(node.content, node);
            if (similar != null) {
                node.markRemove();
                similar.markRemove();
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            if (!nodes.get(i).remove) {
                ans.add(paths.get(i));
            }
        }
        return ans;
    }
}