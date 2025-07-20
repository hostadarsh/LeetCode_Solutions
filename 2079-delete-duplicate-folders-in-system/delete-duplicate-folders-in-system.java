class Solution 
{
    static class Node 
    {
        Map<String, Node> children = new HashMap<>();
        boolean del = false;
    }

    Map<String, List<Node>> seen = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) 
    {
        Node root = new Node();

        // Step 1: Build the folder tree (Trie)
        for (List<String> path : paths) 
        {
            Node cur = root;
            for (String dir : path) 
            {
                cur.children.putIfAbsent(dir, new Node());
                cur = cur.children.get(dir);
            }
        }

        // Step 2: Serialize each subtree
        dfs(root);

        // Step 3: Mark duplicate subtrees
        for (List<Node> group : seen.values()) 
        {
            if (group.size() > 1) 
            {
                for (Node node : group) 
                {
                    node.del = true;
                }
            }
        }

        // Step 4: Collect non-duplicate folder paths
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        collect(root, path, res);
        return res;
    }

    public String dfs(Node node) 
    {
        if (node.children.isEmpty())
        {
            return "";
        } 

        List<String> subs = new ArrayList<>();
        for (String name : node.children.keySet()) 
        {
            String childSerial = dfs(node.children.get(name));
            subs.add(name + "(" + childSerial + ")");
        }

        Collections.sort(subs);
        String serial = String.join("", subs);
        seen.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);

        return serial;
    }

    public void collect(Node node, List<String> path, List<List<String>> res) 
    {
        for (Map.Entry<String, Node> entry : node.children.entrySet()) 
        {
            if (entry.getValue().del)
            {
                continue;
            } 

            path.add(entry.getKey());
            res.add(new ArrayList<>(path));
            collect(entry.getValue(), path, res);
            path.remove(path.size() - 1);
        }
    }
}