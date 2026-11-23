// class ProductOfNumbers {
//     private final List<Integer> prefix = new ArrayList<>(List.of(1));  // prefix[i]: the product of the first i numbers after the last zero

//     public void add(int num) {
//         if (num == 0) {
//             prefix.clear();  // a window that reaches this zero is 0, so forget everything before it
//             prefix.add(1);
//         } else {
//             prefix.add(prefix.get(prefix.size() - 1) * num);
//         }
//     }

//     public int getProduct(int k) {
//         int n = prefix.size();
//         if (k >= n)  // the window reaches back to a zero
//             return 0;
//         return prefix.get(n - 1) / prefix.get(n - 1 - k);
//     }
// }


class ProductOfNumbers {
    private int[] list;
    private int size;

    public ProductOfNumbers() {
        list = new int[16];
        list[0] = 1;
        size = 1;
    }
    
    public void add(int num) {
        if(num == 0 ) {
            size = 1;
            list[0] = 1;
        }
        else {
            if(size == list.length) {
                list = Arrays.copyOf(list,size*2);
            }
            list[size] =  list[size-1] * num;
            size++;
        }

    }
    
    public int getProduct(int k) {

        if(k >= size ) {
            return  0;
        }
        return list[size-1] / list[size-1-k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */