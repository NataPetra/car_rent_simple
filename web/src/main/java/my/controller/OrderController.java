package my.controller;

import my.beans.OrderCommonBean;
import my.service.order_services.AddOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private AddOrderService addOrderService;

    @GetMapping("/order/{car.id}.view")
    public ModelAndView orderPage(@PathVariable("car.id") Integer id){
        return new ModelAndView("order",
                Map.of("autoCommonBean", addOrderService.getAutoCommonBeanForOrder(id),
                        "listOfDates", addOrderService.listOfDatesForMessage(id)));
    }

    @PostMapping("/order/{car.id}.action")
    public String addOrderCommon(@PathVariable("car.id") Integer id,
                                 @RequestParam("sdate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate sdate,
                                 @RequestParam("fdate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fdate,
                                 OrderCommonBean orderCommonBean){
        addOrderService.addOrder(id, orderCommonBean, sdate, fdate);
        return "redirect:/details_auto/{car.id}.view";

    }

}
