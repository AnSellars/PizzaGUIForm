import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
public class PizzaGUIFrame extends JFrame
{

    JPanel mainPnl;
    JPanel buttonPnl;
    JPanel orderPnl;
    JPanel textPnl;
    JButton quitBtn;
    JButton clearBtn;
    JButton orderBtn;
    Double crustSizeTotal;
    Double ingredientTotal;
    Double subTotal;
    Double tax;
    Double finalTotal;
    JTextArea recipt;
    ButtonGroup crust;
    JCheckBox cobalt;
    JCheckBox silver;
    JCheckBox silicon;
    JCheckBox einsteinium;
    JCheckBox carbon;
    JCheckBox neon;
    JCheckBox krypton;
    JCheckBox hafnium;
    JRadioButton thinRB;
    JRadioButton regularRB;
    JRadioButton deepDishRB;
    JPanel crustPnl;
    JPanel sizePnl;
    JComboBox sizeCB;
    JPanel toppingPnl;
    JScrollPane scrollPane;

    public PizzaGUIFrame()
    {

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        setTitle("Pizza Order");

        createBtnPnl();
        mainPnl.add(buttonPnl,BorderLayout.SOUTH);
        createOrderPnl();
        mainPnl.add(orderPnl,BorderLayout.NORTH);
        createTxtPnl();
        mainPnl.add(textPnl,BorderLayout.CENTER);
        add(mainPnl);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createBtnPnl()
    {

        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));

        String divider = new String("========================================\n");
        String divider2 = new String("----------------------------------------------------------------------\n");

        orderBtn = new JButton("Order");
        orderBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        orderBtn.addActionListener((ActionEvent ae) ->
        {
            ingredientTotal = 0.0;
            if(cobalt.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(silver.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(silicon.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(einsteinium.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(carbon.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(neon.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(krypton.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }
            if(hafnium.isSelected())
            {
                ingredientTotal = ingredientTotal + 1.0;
            }

            crustSizeTotal = 0.0;

            if(sizeCB.getSelectedItem() == "Small")
            {
                crustSizeTotal = crustSizeTotal + 8.0;
            } else if (sizeCB.getSelectedItem() == "Medium") {
                crustSizeTotal = crustSizeTotal + 12.0;
            } else if (sizeCB.getSelectedItem() == "Large") {
                crustSizeTotal = crustSizeTotal + 16.0;
            } else if (sizeCB.getSelectedItem() == "Super") {
                crustSizeTotal = crustSizeTotal + 20.0;
            }

            subTotal = crustSizeTotal + ingredientTotal;
            tax = subTotal * .07;
            finalTotal = tax + subTotal;

            recipt.append(divider);
            recipt.append("Type of Crust & Size                      " + crustSizeTotal + "\n");
            recipt.append("Ingredient                                        " + ingredientTotal + "\n");
            recipt.append("\n");
            recipt.append("Sub-total:                                         " + subTotal + "\n");
            recipt.append("Tax:                                                   " + Math.round(tax) + "\n");
            recipt.append(divider2);
            recipt.append("Total:                                                " + Math.round(finalTotal) + "\n");
            recipt.append(divider);

        });

        buttonPnl.add(orderBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        clearBtn.addActionListener((ActionEvent ae) ->
        {

            crust.clearSelection();
            sizeCB.setSelectedItem("Small");
            cobalt.setSelected(false);
            silver.setSelected(false);
            silicon.setSelected(false);
            einsteinium.setSelected(false);
            carbon.setSelected(false);
            neon.setSelected(false);
            krypton.setSelected(false);
            hafnium.setSelected(false);

        });

        buttonPnl.add(clearBtn);

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        quitBtn.addActionListener((ActionEvent ae) ->
        {int quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?","Quit Confirm", JOptionPane.YES_NO_OPTION);
                if(quit == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
        });

        buttonPnl.add(quitBtn);


    }

    private void createOrderPnl()
    {

        orderPnl = new JPanel();
        orderPnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        crustPnl = new JPanel();
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust"));
        thinRB = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB = new JRadioButton("Deep-Dish");

        crustPnl.add(thinRB);
        crustPnl.add(regularRB);
        crustPnl.add(deepDishRB);

        crust = new ButtonGroup();
        crust.add(thinRB);
        crust.add(regularRB);
        crust.add(deepDishRB);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        orderPnl.add(crustPnl, c);

        sizePnl = new JPanel();
        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
        sizeCB = new JComboBox<>();
        sizeCB.addItem("Small");
        sizeCB.addItem("Medium");
        sizeCB.addItem("Large");
        sizeCB.addItem("Super");
        sizePnl.add(sizeCB);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        orderPnl.add(sizePnl, c);

        toppingPnl = new JPanel();
        toppingPnl.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        cobalt = new JCheckBox("Cobalt");
        silver = new JCheckBox("Silver");
        silicon = new JCheckBox("Silicon");
        einsteinium = new JCheckBox("Einsteinium");
        carbon = new JCheckBox("Carbon");
        neon = new JCheckBox("Neon");
        krypton = new JCheckBox("Krypton");
        hafnium = new JCheckBox("Hafnium");

        toppingPnl.add(cobalt);
        toppingPnl.add(silver);
        toppingPnl.add(silicon);
        toppingPnl.add(einsteinium);
        toppingPnl.add(carbon);
        toppingPnl.add(neon);
        toppingPnl.add(krypton);
        toppingPnl.add(hafnium);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        orderPnl.setSize(400,40);
        orderPnl.add(toppingPnl);



    }

    private void createTxtPnl()
    {

        textPnl = new JPanel();
        textPnl.setLayout(new BorderLayout());
        recipt = new JTextArea();
        scrollPane = new JScrollPane(recipt);
        textPnl.add(scrollPane);

    }


}
