package Generic;

import java.util.Random;


public class Generic
{


    public static void main( String args[] ){
        new Generic();
    } 
    
    public Generic(){
    	System.out.println("���ͽӿ�:");
    	genericInterface();
    	System.out.println("\n���ͷ���:");
    	genericMethod();
    	System.out.println("\n\n������:");
    	genericClass();
    }
    
    /**
     * ���ͷ���               
     * @param inputArray
     */
    public static <T> void printArray( T[] inputArray )
    {
       // �������Ԫ��            
          for ( T element : inputArray ){        
             System.out.printf( "%s ", element );
          }
     }
    
    public void genericMethod(){
        // ������ͬ�������飺 Integer, Double �� Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "��������Ԫ��Ϊ:" );
        printArray( intArray  ); // ����һ����������

        System.out.println( "\n˫����������Ԫ��Ϊ:" );
        printArray( doubleArray ); // ����һ��˫����������

        System.out.println( "\n�ַ�������Ԫ��Ϊ:" );
        printArray( charArray ); // ����һ���ַ�������
    }
    
    /**
     * ���ͽӿ�
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
     * ������
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
