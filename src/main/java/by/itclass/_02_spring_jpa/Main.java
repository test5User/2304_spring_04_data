package by.itclass._02_spring_jpa;

import by.itclass._02_spring_jpa.config.AppConfig;
import by.itclass._02_spring_jpa.entities.Airplane;
import by.itclass._02_spring_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = ctx.getBean(AirplaneRepository.class);

//        var boeing736 = ctx.getBean("boeing736", Airplane.class);
//        System.out.println("We just bought airplane: " + boeing736);
//
//        boeing736 = repository.save(boeing736);
//        System.out.println("We registered airplane: " + boeing736);
//
//        boeing736.setPlaces(160);
//        boeing736 = repository.save(boeing736);
//        System.out.println("We changed places in boeing: " + boeing736);
        System.out.println(repository.findByModel("AirBus-300"));
        System.out.println(repository.findByModelAndPlaces("AirBus-300", 100));
        System.out.println(repository.findByModelLike("%736"));
        System.out.println("_______________________________________");
        repository.findByIdBetween(2, 10).forEach(System.out::println);
    }
}
