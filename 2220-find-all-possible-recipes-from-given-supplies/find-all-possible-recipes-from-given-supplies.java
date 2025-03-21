// class Solution {
//     private Set<String> availableSupplies;
//     private Map<String, List<String>> recipeToIngredients;
//     private Map<String, Integer> visited;
//     private List<String> result;

//     public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//         availableSupplies = new HashSet<>(Arrays.asList(supplies));
//         recipeToIngredients = new HashMap<>();
//         visited = new HashMap<>();
//         result = new ArrayList<>();

//         for (int i = 0; i < recipes.length; i++) {
//             recipeToIngredients.put(recipes[i], ingredients.get(i));
//         }

//         for (String recipe : recipes) {
//             canMake(recipe);
//         }

//         return result;
//     }

//     private boolean canMake(String recipe) {
//         if (visited.containsKey(recipe)) {
//             return visited.get(recipe) == 1;
//         }

//         if (availableSupplies.contains(recipe)) {
//             return true;
//         }

//         if (!recipeToIngredients.containsKey(recipe)) {
//             return false;
//         }

//         visited.put(recipe, 0);

//         for (String ingredient : recipeToIngredients.get(recipe)) {
//             if (!canMake(ingredient)) {
//                 visited.put(recipe, -1);
//                 return false;
//             }
//         }

//         visited.put(recipe, 1);
//         result.add(recipe);
//         return true;
//     }
// }

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        return new AbstractList<String>() {
            List<String> result;

            @Override
            public String get(int index) {
                return result.get(index);
            }

            @Override
            public int size() {
                if (result == null) {
                    init();
                }
                return result.size();
            }

            private void init() {
                Set<String> supplieSets = new HashSet<>(Arrays.asList(supplies));

                Map<String, List<String>> graph = new HashMap<>();
                Map<String, Integer> inDegreeMap = new HashMap<>();
                for (int i = 0; i < recipes.length; i++) {
                    for (String ingredient : ingredients.get(i)) {
                        if (!supplieSets.contains(ingredient)) {
                            graph.putIfAbsent(ingredient, new ArrayList<>());
                            graph.get(ingredient).add(recipes[i]);
                            inDegreeMap.merge(recipes[i], 1, Integer::sum);
                        }
                    }
                }
                Deque<String> deque = new ArrayDeque<>();
                for (String recipe : recipes) {
                    if (inDegreeMap.getOrDefault(recipe, 0) == 0) {
                        deque.offer(recipe);
                    }
                }
                result = new ArrayList<>();
                while (!deque.isEmpty()) {
                    String current = deque.poll();
                    result.add(current);
                    List<String> child = graph.get(current);
                    if (child != null) {
                        for (String chd : child) {
                            inDegreeMap.merge(chd, -1, Integer::sum);
                            if (inDegreeMap.get(chd) == 0) {
                                deque.offer(chd);
                            }
                        }
                    }
                }
            }
        };
    }
}