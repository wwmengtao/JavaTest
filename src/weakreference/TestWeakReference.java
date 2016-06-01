package weakreference;

import java.lang.ref.WeakReference;
public class TestWeakReference {
	public static void main(String[] args) {
		
		Car car = new Car(22000,"silver");
		WeakReference<Car> weakCar = new WeakReference<Car>(car);
		int i=0;
		while(true){
			//下列语句是否存在决定着car是否被回收
			//System.out.println("here is the strong reference 'car' "+car);
			if(weakCar.get()!=null){
				i++;
				System.out.println("Object is alive for "+i+" loops - "+weakCar);
			}else{
				System.out.println("Object has been collected.");
				break;
			}
		}
	}
}
