package my.controller;

import my.beans.OrderCommonBean;
import my.service.order_services.AddOrderService;
import my.service.order_services.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private AddOrderService addOrderService;

    @Autowired
    private OrderReportService orderReportService;

    @GetMapping("/order/{car.id}.view")
    public ModelAndView orderPage(@PathVariable("car.id") Integer id) {
        return new ModelAndView("order",
                Map.of("autoCommonBean", addOrderService.getAutoCommonBeanForOrder(id),
                        "listOfDates", addOrderService.listOfDatesForMessage(id)));
    }

    @PostMapping("/order/{car.id}.action")
    public String addOrderCommon(@PathVariable("car.id") Integer id,
                                       @RequestParam("sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate sdate,
                                       @RequestParam("fdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fdate,
                                       OrderCommonBean orderCommonBean,
                                       RedirectAttributes redirectAttributes) {
        Integer orderId = addOrderService.addOrder(id, orderCommonBean, sdate, fdate);
        redirectAttributes.addFlashAttribute("orderId", orderId);
        return "redirect:/report";
    }

    @GetMapping("/report")
    public String handleForexRequest(@ModelAttribute("orderId") Integer id,
                                     Model model) {
        System.out.println(id);
        model.addAttribute("report", orderReportService.createPDFOrderFile(id));
        return "reportView";
    }
}
