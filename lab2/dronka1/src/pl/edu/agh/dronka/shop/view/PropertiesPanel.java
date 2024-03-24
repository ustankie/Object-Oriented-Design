package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.items.Book;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.items.ElectronicItem;
import pl.edu.agh.dronka.shop.model.items.Music;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

    private static final long serialVersionUID = -2804446079853846996L;
    private ShopController shopController;

    private ItemFilter filter = new ItemFilter();

    public PropertiesPanel(ShopController shopController) {
        this.shopController = shopController;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void fillProperties(Category category) {
        removeAll();

        filter.setCategory(category);
        add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                filter.getItemSpec().setPolish(
                        ((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }
        }));

        add(createPropertyCheckbox("Używany", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                filter.getItemSpec().setSecondhand(
                        ((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }
        }));

        switch (category) {
            case BOOKS -> add(createPropertyCheckbox("Twarda okładka", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    ((Book) filter.getItemSpec()).setSolidCover(
                            ((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }
            }));
            case ELECTRONICS -> {
                add(createPropertyCheckbox("Mobilny", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        ((ElectronicItem) filter.getItemSpec()).setMobile(
                                ((JCheckBox) event.getSource()).isSelected());
                        shopController.filterItems(filter);
                    }
                }));
                add(createPropertyCheckbox("Gwarancja", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        ((ElectronicItem) filter.getItemSpec()).setGuarantee(
                                ((JCheckBox) event.getSource()).isSelected());
                        shopController.filterItems(filter);
                    }
                }));
            }
            case MUSIC -> add(createPropertyCheckbox("Wideo", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    ((Music) filter.getItemSpec()).setVideoAttached(
                            ((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }
            }));
        }

    }

    private JCheckBox createPropertyCheckbox(String propertyName,
                                             ActionListener actionListener) {

        JCheckBox checkBox = new JCheckBox(propertyName);
        checkBox.setSelected(false);
        checkBox.addActionListener(actionListener);

        return checkBox;
    }

}
