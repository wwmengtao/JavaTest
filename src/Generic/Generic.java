package Generic;

import java.util.Random;


public class Generic
{


    public static void main( String args[] ){
        new Generic();
    } 
    
    public Generic(){
    	System.out.println("泛型接口:");
    	genericInterface();
    	System.out.println("\n泛型方法:");
    	genericMethod();
    	System.out.println("\n\n泛型类:");
    	genericClass();
    }
    
    /**
     * 泛型方法               
     * @param inputArray
     */
    public static <T> void printArray( T[] inputArray )
    {
       // 输出数组元素            
          for ( T element : inputArray ){        
             System.out.printf( "%s ", element );
          }
     }
    
    public void genericMethod(){
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    }
    
    /**
     * 泛型接口
     * @author Mengtao1
     *
     * @param <T>
     */
    public interface Generator<T> {
        public T next();
    }
    
    public class FruitGenerator implements Generator<String> {

        private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

        @Override
        public String next() {
            Random rand = new Random();
            return fruits[rand.nextInt(3)];
        }
    }
    
    public void genericInterface(){
        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
    }
    
    /**
     * 泛型类
     * @author Mengtao1
     *
     * @param <K>
     * @param <V>
     */
    public class Container<K, V> {
        private K key;
        private V value;

        public Container(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    
    public void genericClass(){
        Container<String, String> c1 = new Container<String, String>("name", "findingsea");
        Container<String, Integer> c2 = new Container<String, Integer>("age", 24);
        Container<Double, Double> c3 = new Container<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
    }
}
