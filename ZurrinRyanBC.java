/**
*@filename ZurrinRyanBC.java
*@author Ryan Zurrin
*@assignment Chapter 12 Program 2 option b 'Little Blue Clicker App'
*@due_date Tuesday, December 15, 2020, 3:00 PM
*@description Use online research to learn about Java swing, the
*KeyListener and implementing a KeyEvent that allows a user to type a
*key on the keyboard that will represent a virtual key on the screen. This
*program is a money counter that goes up to 99.99 at which point the
*error window will turn red and you will have to reset to continue
*/
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ZurrinRyanBC extends javax.swing.JFrame
{
	private javax.swing.JButton centButton;
	private javax.swing.JTextField centTextField;
	private javax.swing.JButton dimeButton;
	private javax.swing.JTextField dimeTextField;
	private javax.swing.JButton dollarButton;
	private javax.swing.JTextField dollarTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private java.awt.Panel overFlowPanel;
	private javax.swing.JButton resetButton;
    private int _cent;
    private int _dime;
    private int _dollar;
    private boolean overflowError;
    KeyListener listener;

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info :
	            javax.swing.UIManager.getInstalledLookAndFeels())
	            {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(
							info.getClassName());
							break;
	                }
	         	}
	  	}
	  	catch (ClassNotFoundException ex)
	  	{
			java.util.logging.Logger.getLogger(
				ZurrinRyanBC.class.getName())
				.log(java.util.logging.Level.SEVERE, null, ex);
	    }
	    catch (InstantiationException ex)
	    {
			java.util.logging.Logger.getLogger(
				ZurrinRyanBC.class.getName())
				.log(java.util.logging.Level.SEVERE, null, ex);
	    }
	    catch (IllegalAccessException ex)
	    {
			java.util.logging.Logger.getLogger(
				ZurrinRyanBC.class.getName())
				.log(java.util.logging.Level.SEVERE, null, ex);
	    }
	    catch (javax.swing.UnsupportedLookAndFeelException ex)
	    {
			java.util.logging.Logger.getLogger(
				ZurrinRyanBC.class.getName())
				.log(java.util.logging.Level.SEVERE, null, ex);
	    }

	    // creates a new visiable instance of the class calling
	    // the no argument constructor which builds the JFrame and
	    // swing app using a series of initialzing methods
	    java.awt.EventQueue.invokeLater(
			new Runnable()
			{
				@Override
				public void run()
				{
					new ZurrinRyanBC().setVisible(true);
				}
			}
	    );
    }//end method main

    /**
    * no argument constructor that calls the initComponants to build
    * application
    */
    public ZurrinRyanBC()
    {
        initComponents();

    }//end no argument constructor

    /**
    * adds one cent to the counter and will test where the count is at and
    * will add one to the dime when it is at 9, and will then reset to 0
    */
    public void addCent()
    {
        if(_cent == 9 && overflowError == false){
              addDime();
               _cent = 0;
            centTextField.setText(Integer.toString(_cent));
        }
        else if(overflowError == false){
            _cent++;
            centTextField.setText(Integer.toString(_cent));
        }
    }//end method addCent

    /**
    * adds a dime to the counter and will test where the count is at and will
    * add one to the dollar when it is at 9, and will then reset to 0
    */
    public void addDime()
    {
        if(_dime == 9 && overflowError == false){
             addDollar();
             if(overflowError == false){
                  _dime = 0;
             }
            dimeTextField.setText(Integer.toString(_dime));
        }
        else if(overflowError == false){
            _dime++;
            dimeTextField.setText(Integer.toString(_dime));
        }
    }//end method addDime

  	/**
    * adds a dollar to the counter. when it goes above 99 it will
    * trigger an overflow error
    */
    public void addDollar()
    {
        if(_dollar == 99){
            overflowError = true;
            _dime = 9;
            _cent = 9;
            dollarTextField.setText(Integer.toString(_dollar));
            dimeTextField.setText(Integer.toString(_dime));
            centTextField.setText(Integer.toString(_cent));
            overFlowPanel.setBackground(Color.red);
        }
        else if(overflowError == false){
            _dollar++;
            dollarTextField.setText(Integer.toString(_dollar));
        }
    }//end method addDollar

    /**
     * resets the counter to all zeros
     */
    public void reset()
    {
        overflowError = false;
        _cent = 0;
        _dime = 0;
        _dollar = 0;
        dollarTextField.setText("00");
        dimeTextField.setText("0");
        centTextField.setText("0");
        overFlowPanel.setBackground(Color.GREEN);
    }//end method reset

   	/**
    * initializes the componants and builds the GUI. This code was mostly
    * generated by netbeans WYSIWYG editor
  	*/
    @SuppressWarnings("unchecked")
    private void initComponents() {

		// initializing all the componants
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dollarButton = new javax.swing.JButton();
        dimeButton = new javax.swing.JButton();
        centButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        dollarTextField = new javax.swing.JTextField();
        dimeTextField = new javax.swing.JTextField();
        centTextField = new javax.swing.JTextField();
        overFlowPanel = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        /**
        * KeyListener interface must  override its 3 methods upon implementing
		* they are the following mehods keyTyped(), keyPressed(), keyReleased()
		*/
		listener = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if(e.getKeyChar() == 'E' || e.getKeyChar() == 'e')
				{
					dollarButton.requestFocusInWindow();
		            addDollar();
		        }//end E key check

		        if(e.getKeyChar() == 'D' || e.getKeyChar() == 'd')
		        {
					dimeButton.requestFocusInWindow();
		            addDime();
		        }//end D key check

		        if(e.getKeyChar() == 'C' || e.getKeyChar() == 'c')
		        {
					centButton.requestFocusInWindow();
		         	addCent();
		        }//end C key check

		        if(e.getKeyChar() == 'R' || e.getKeyChar() == 'r')
		        {
					resetButton.requestFocusInWindow();
		            reset();
		   		}//end R key check
		   	}//end method keyTyped

			/**
			* Using  KeyPressed KeyEvent to set the button color to pink when
			* the listener detects any of the specified key presses.
			* @param e KeyEvent caused by a user pressing one of the following
			* keyboard keys:
			* E for a dollar, a D for a dime, a C for a cent and R to reset
			*/@Override
		     public void keyPressed(KeyEvent e)
		     {
				 if(e.getKeyChar() == 'E' || e.getKeyChar() == 'e')
				 {
					 dollarButton.setBackground(Color.PINK);
				 }
		         if(e.getKeyChar() == 'D' || e.getKeyChar() == 'd')
		         {
		             dimeButton.setBackground(Color.PINK);
		         }
		         if(e.getKeyChar() == 'C' || e.getKeyChar() == 'c')
		         {
		             centButton.setBackground(Color.PINK);
		         }
		         if(e.getKeyChar() == 'R' || e.getKeyChar() == 'r')
		         {
		             resetButton.setBackground(Color.PINK);
		         }
		     }//end method kepPressed

			/**
			* Using  keyReleased KeyEvent to set the button color to yellow if
			* the listener detects any of the specified key presses.
			* @param e KeyEvent caused by a user releasing one of the following
			* keyboard keys:
			* E for a dollar, a D for a dime, a C for a cent and an R to reset
			*/@Override
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyChar() == 'E' || e.getKeyChar() == 'e')
				{
					dollarButton.setBackground(Color.YELLOW);
				}
		        if(e.getKeyChar() == 'D' || e.getKeyChar() == 'd')
		        {
		            dimeButton.setBackground(Color.YELLOW);
		        }
		        if(e.getKeyChar() == 'C' || e.getKeyChar() == 'c')
		        {
		            centButton.setBackground(Color.YELLOW);
		        }
		        if(e.getKeyChar() == 'R' || e.getKeyChar() == 'r')
		        {
		            resetButton.setBackground(Color.YELLOW);
		        }
		     }//end method KeyReleased
		};//end KeyListener instantiation

		/**
		* adding the listener to the JButtons
		*/
		dollarButton.addKeyListener(listener);
		dimeButton.addKeyListener(listener);
		centButton.addKeyListener(listener);
		resetButton.addKeyListener(listener);

        overflowError = false;

//very important this is set to close the window when the x is clicked
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//setting the title that is on the top bar
        setTitle("Blue $ Clicker");

//setting background colors and styles of window panels
        setBackground(new java.awt.Color(0, 204, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(
			javax.swing.border.BevelBorder.RAISED,
			java.awt.Color.yellow, java.awt.Color.blue,
			java.awt.Color.yellow, java.awt.Color.green));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
			null,
			"",
			javax.swing.border.TitledBorder.CENTER,
			javax.swing.border.TitledBorder.BOTTOM));

//setting look and feel of dollar button and adding its action listener
        dollarButton.setBackground(java.awt.Color.yellow);
        dollarButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dollarButton.setText("E");
        dollarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDollar();
            }
        });

//setting look and feel of dime button and adding its action listener
        dimeButton.setBackground(java.awt.Color.yellow);
        dimeButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dimeButton.setText("D");
        dimeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addDime();
		    }
        });

//setting look and feel of cent button and adding its action listener
        centButton.setBackground(java.awt.Color.yellow);
        centButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        centButton.setText("C");
        centButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCent();
            }
        });

//setting look and feel of reset button and adding its action listener
        resetButton.setBackground(java.awt.Color.yellow);
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resetButton.setText("R");
        resetButton.setToolTipText("");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset();
            }
        });

//setting look and feel of dollar display
        dollarTextField.setEditable(false);
        dollarTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dollarTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dollarTextField.setText("00");
        dollarTextField.setFocusable(false);

//setting look and feel of dime display
        dimeTextField.setEditable(false);
        dimeTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dimeTextField.setText("0");
        dimeTextField.setFocusable(false);

//setting look and feel of cent display
        centTextField.setEditable(false);
        centTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        centTextField.setText("0");
        centTextField.setFocusable(false);

//setting look and feel of overFlow panel display
        overFlowPanel.setBackground(new java.awt.Color(51, 255, 51));
        overFlowPanel.setMinimumSize(new java.awt.Dimension(42, 36));
        overFlowPanel.setPreferredSize(new java.awt.Dimension(42, 36));

//setting the gap in the horizontal and vertical alignment of the buttons and textFields
        javax.swing.GroupLayout overFlowPanelLayout =
        	new javax.swing.GroupLayout(overFlowPanel);
        overFlowPanel.setLayout(overFlowPanelLayout);
        overFlowPanelLayout.setHorizontalGroup(
            overFlowPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        overFlowPanelLayout.setVerticalGroup(
            overFlowPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

//setting up the look and feel of Dollar label
        jLabel1.setFont(
			jLabel1.getFont().deriveFont(
				jLabel1.getFont().getStyle() |
				java.awt.Font.BOLD, jLabel1.getFont().getSize()+5)
				);
        jLabel1.setText("Dollars");

//setting up the look and feel of Dimes label
        jLabel2.setFont(
			jLabel2.getFont().deriveFont(
				jLabel2.getFont().getStyle() |
				java.awt.Font.BOLD, jLabel2.getFont().getSize()+5));
        jLabel2.setText("Dimes");

//setting up the look and feel of Cents label
        jLabel3.setFont(
			jLabel3.getFont().deriveFont(
				jLabel3.getFont().getStyle() |
				java.awt.Font.BOLD, jLabel3.getFont().getSize()+5));
        jLabel3.setText("Cents");

//setting up the look and feel of Reset label
        jLabel4.setFont(
			jLabel4.getFont().deriveFont(
				jLabel4.getFont().getStyle() |
				java.awt.Font.BOLD, jLabel4.getFont().getSize()+5));
        jLabel4.setText("Reset");

//just a couple lines to set the look and feel of the group layouts
        javax.swing.GroupLayout jPanel2Layout =
        	new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);

//horizontal group layout
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(
							javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
								dollarButton,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
                            .addComponent(dollarTextField)))
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing
							.LayoutStyle
							.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(dimeButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(
							dimeTextField,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(
					jPanel2Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(centButton))
                    .addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(
							javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(
							jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
								jLabel3,
								javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout.createSequentialGroup()
                                .addComponent(centTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addGap(18, 18, 18)
                .addGroup(
					jPanel2Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(
							javax.swing.GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE))
                    .addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(
							jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
								overFlowPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetButton))
                        .addGap(14, 14, 14))))
        );//end of horizontal group layout

//vertical group layout
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(
						overFlowPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(
						jPanel2Layout.createParallelGroup(
							javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(
							dollarTextField,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(
							dimeTextField,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(
							centTextField,
							javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(
					jPanel2Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
						jPanel2Layout.createParallelGroup(
							javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dollarButton)
                        .addComponent(centButton)
                        .addComponent(resetButton))
                    .addComponent(dimeButton))
                .addPreferredGap(
					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
					jPanel2Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
						jPanel2Layout.createParallelGroup(
							javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGroup(
						jPanel2Layout.createParallelGroup(
							javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))))
        );//end vertical group layout

// setting the jPanel group layout
        javax.swing.GroupLayout jPanel1Layout =
        	new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(
					jPanel2,
					javax.swing.GroupLayout.PREFERRED_SIZE,
					275,
					javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(
					14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(
					jPanel2,
					javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout =
        	new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
				jPanel1,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(
					jPanel1,
					javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.PREFERRED_SIZE))
        );

		/**
		* Causes this Window to be sized to fit the preferred size
		* and layouts of its subcomponents. The resulting width and
		* height of the window are automatically enlarged if either
		* of dimensions is less than the minimum size as specified
	    * by the previous call to the {@code setMinimumSize} method.
		* If the window and/or its owner are not displayable yet,
		* both of them are made displayable before calculating
		* the preferred size. The Window is validated after its
		* size is being calculated.
		* @see Component#isDisplayable
  	  	* @see #setMinimumSize
     	*/
        pack();

    }//end method initComponants

}//end class ZurrinRyanBC