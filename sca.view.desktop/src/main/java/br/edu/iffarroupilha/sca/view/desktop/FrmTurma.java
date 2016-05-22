package br.edu.iffarroupilha.sca.view.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Interface para cadastro e edição de turmas
 * </p>
 * 
 * @since 22/03/2016 21:43
 */
public class FrmTurma extends JFrame {
	private JTable table;

	public FrmTurma() {
		setTitle("Cadastro Turma");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		populaTabela();
		setVisible(true);
	}

	private void populaTabela() {

		TurmaControle controle = new TurmaControle();
		
		List turmas = controle.listar(Turma.class);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		// reseta a tabela
		modelo.setRowCount(0);
		
		for (Object obj : turmas) {
			
			Turma aux = (Turma) obj;
			Object linha[] = new Object[2];
			linha[0] = aux.getIdTurma();
			linha[1] = aux.getDescricao();
			modelo.addRow( linha  );
			
		}
		
	}

	private void desenhaComponentes() {
		JLabel lbl = new JLabel("Descrição:");
		final JTextField jtfDescricao = new JTextField("",20);
		JButton btnGravar = new JButton("Gravar");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(lbl)
							.addGap(5)
							.addComponent(jtfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnGravar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(jtfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(btnGravar)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(249);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		
		btnGravar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Turma t = new Turma();
				t.setDescricao( jtfDescricao.getText()  );
				
				new TurmaControle().gravar(t);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
				populaTabela();
			}
		}  );
		
	}

	public static void main(String[] args) {
		new FrmTurma();
	}

}
