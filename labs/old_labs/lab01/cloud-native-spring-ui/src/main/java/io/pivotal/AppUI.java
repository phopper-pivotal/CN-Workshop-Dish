package io.pivotal;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import io.pivotal.domain.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

@SpringUI
@Theme("valo")
public class AppUI extends UI {

    private final CloudNativeSpringUiApplication.CityService _client;
    private final Grid _grid;

    @Autowired
    public AppUI(CloudNativeSpringUiApplication.CityService client) {
        _client = client;
        _grid = new Grid();
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(_grid);
        _grid.setWidth(100, Unit.PERCENTAGE);
        _grid.setHeight(100, Unit.PERCENTAGE);
        _grid.setHeaderVisible(true);
        _grid.setColumnReorderingAllowed(true);
        Collection<City> collection = new ArrayList<City>();
        _client.getCities().forEach(collection::add);
        _grid.setContainerDataSource(new BeanItemContainer<City>(City.class, collection));
    }
}