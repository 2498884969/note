package factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法，即先需要创建工厂本身，再调用工厂的方法返回bean的实例
 */


public class InstanceCarFactory {
    private Map<String, Car> cars = null;
    public InstanceCarFactory(){
        cars = new HashMap<String,Car>();
        cars.put("audi",new Car("audi",300000));
        cars.put("Ford",new Car("Ford",400000));
    }
    public Car getCar(String brand){
        return cars.get(brand);
    }
}
