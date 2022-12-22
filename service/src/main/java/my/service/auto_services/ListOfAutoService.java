package my.service.auto_services;

import my.beans.ShowAutoBean;
import my.entity.auto.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ListOfAutoService {

    @Autowired
    private AutoService autoService;

    public List<ShowAutoBean> showAutoBriefly(){
        List<Auto> auto = autoService.allAuto();
        List<ShowAutoBean> showAutoBeans = new ArrayList<>();
        for (Auto value : auto) {
            ShowAutoBean showAutoBean = new ShowAutoBean();
            showAutoBean.setNumber(value.getId());
            showAutoBean.setModel(value.getModel().getModelName().toUpperCase());
            showAutoBean.setBrand(value.getBrand().getBrandName().toUpperCase());
            showAutoBean.setColour(value.getColour());
            showAutoBean.setPrice(value.getPrice().toString());
            showAutoBeans.add(showAutoBean);
            System.out.println("Add in showAutoBeans: " + showAutoBean);
        }
        for (ShowAutoBean autoBean:
             showAutoBeans) {
            System.out.println(autoBean);
        }
        return showAutoBeans;
    }

    public List showAutoPage(int pageNumber, int pageSize){
        List<Auto> auto = autoService.allAuto(pageNumber, pageSize);
        List<ShowAutoBean> showAutoBeans = new ArrayList<>();
        for (Auto value : auto) {
            ShowAutoBean showAutoBean = new ShowAutoBean();
            showAutoBean.setNumber(value.getId());
            showAutoBean.setModel(value.getModel().getModelName().toUpperCase());
            showAutoBean.setBrand(value.getBrand().getBrandName().toUpperCase());
            showAutoBean.setColour(value.getColour());
            showAutoBean.setPrice(value.getPrice().toString());
            showAutoBeans.add(showAutoBean);
            System.out.println("Add in showAutoBeans: " + showAutoBean);
        }
        for (ShowAutoBean autoBean:
                showAutoBeans) {
            System.out.println(autoBean);
        }
        return showAutoBeans;
    }

}
