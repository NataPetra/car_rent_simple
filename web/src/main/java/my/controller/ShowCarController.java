package my.controller;

import my.beans.ShowAutoBean;
import my.service.auto_services.AutoService;
import my.service.auto_services.ListOfAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ShowCarController {

    @Autowired
    private ListOfAutoService listOfAutoService;
    @Autowired
    private AutoService autoService;

    @GetMapping("/list_cars.view")
    public ModelAndView listOfCar(@RequestParam("model") Optional<String> model) {
        System.out.println("Call list of cars");
        List<ShowAutoBean> autoBeans;
        if(model.isPresent()){
            autoBeans = listOfAutoService.showAutoBriefly(model.get());
        } else {
            autoBeans = listOfAutoService.showAutoBriefly();
        }
        return new ModelAndView(
                "list_cars",
                Map.of("carsList", autoBeans)
        );
    }

    @GetMapping("/list_cars/{pageId}.view")
    public ModelAndView listOfCarPage(@PathVariable int pageId) {
        System.out.println("Call list of cars");
        int total = 5;
        long countAuto = autoService.countAuto();
        List list = listOfAutoService.showAutoPage(pageId - 1, total);
        long amountOfPages = countAuto / total;
        if (countAuto % total != 0) {
            amountOfPages++;
        }
        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i <= amountOfPages; i++) {
            pages.add(i);
        }
        return new ModelAndView(
                "list_cars",
                Map.of("carsList", list,
                        "pages", pages)
        );
    }


}
