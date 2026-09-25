// class Solution {
//     TreeSet<String> ans = new TreeSet<>();

//     void dfs(String s) {
//         int r = s.indexOf('}');

//         // No braces left
//         if (r == -1) {
//             ans.add(s);
//             return;
//         }

//         // Find matching '{'
//         int l = s.lastIndexOf('{', r);

//         String left = s.substring(0, l);
//         String right = s.substring(r + 1);

//         // Content inside { }
//         String inside = s.substring(l + 1, r);

//         for (String part : inside.split(",")) {
//             dfs(left + part + right);
//         }
//     }

//     public List<String> braceExpansionII(String expression) {
//         dfs(expression);
//         return new ArrayList<>(ans);
//     }
// }

class Solution {
  public List<String> braceExpansionII(String expression) {
    return dfs(expression, 0, expression.length() - 1);
  }

  private List<String> dfs(final String expression, int s, int e) {
    TreeSet<String> ans = new TreeSet<>();
    List<List<String>> groups = new ArrayList<>();
    groups.add(new ArrayList<>());
    int layer = 0;
    int left = 0;

    for (int i = s; i <= e; ++i)
      if (expression.charAt(i) == '{' && ++layer == 1)
        left = i + 1;
      else if (expression.charAt(i) == '}' && --layer == 0)
        merge(groups, dfs(expression, left, i - 1));
      else if (expression.charAt(i) == ',' && layer == 0)
        groups.add(new ArrayList<>());
      else if (layer == 0)
        merge(groups, new ArrayList<>(List.of(String.valueOf(expression.charAt(i)))));

    for (final List<String> group : groups)
      for (final String word : group)
        ans.add(word);

    return new ArrayList<>(ans);
  }

  void merge(List<List<String>> groups, List<String> group) {
    if (groups.get(groups.size() - 1).isEmpty()) {
      groups.set(groups.size() - 1, group);
      return;
    }

    List<String> mergedGroup = new ArrayList<>();

    for (final String word1 : groups.get(groups.size() - 1))
      for (final String word2 : group)
        mergedGroup.add(word1 + word2);

    groups.set(groups.size() - 1, mergedGroup);
  }
}