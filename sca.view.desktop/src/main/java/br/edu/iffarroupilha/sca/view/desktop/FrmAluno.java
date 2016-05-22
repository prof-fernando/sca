package br.edu.iffarroupilha.sca.view.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.edu.iffarroupilha.sca.controle.AlunoControle;
import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Interface para cadastro e edição de turmas
 * </p>
 * 
 * @since 22/03/2016 21:43
 */
public class FrmAluno extends JFrame {
	private JTable table;
	private JTextField jtfEmail;
	private JTextField jtfData;
	private JComboBox cmbTurma;
	private JTextField jtfNome;
	// referencia ao aluno editado
	private Aluno alunoEmEdicao;

	public FrmAluno() {
		setTitle("Cadastro Turma");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		populaTabela();
		
		
		
		
		setVisible(true);
	}

	private void populaTabela() {

		AlunoControle controle = new AlunoControle();
		
		List alunos = controle.listar(Aluno.class);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		// reseta a tabela
		modelo.setRowCount(0);
		
		for (Object obj : alunos) {
			
			Aluno aux = (Aluno) obj;
			Object linha[] = new Object[2];
			linha[0] = aux.getMatricula();
			linha[1] = aux.getNome();
			modelo.addRow( linha  );
			
			
		}
		
		
		
	}

	private void desenhaComponentes() {
		JLabel lbl = new JLabel("Descrição:");
		jtfNome = new JTextField("",20);
		JButton btnGravar = new JButton("Gravar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblEmail = new JLabel("Email:");
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.");
		
		jtfData = new JTextField();
		jtfData.setColumns(10);
		
		JLabel lblTurma = new JLabel("Turma");
		
		cmbTurma = new JComboBox();
		
		
		// pegar as turmas cadastradas
		List turmas = new TurmaControle().listar(Turma.class);
		
		for (Object obj : turmas) {
			
			Turma  t = (Turma) obj;
			
			cmbTurma.addItem(t);
			
		}
		
		JButton btnExcluir = new JButton("Excluir");
		
		btnExcluir.addActionListener(  new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// pegar o item selecionado
				int selectedIndex = table.getSelectedRow();
				// se não há linha seleciona retorna-se -1
				if( selectedIndex > -1 ){
					// existe ao menos uma linha selecionada
					int resposta = JOptionPane
					.showConfirmDialog(FrmAluno.this,
					"Tem certeza que deseja excluir?",
					"Excluir",
					JOptionPane.YES_NO_OPTION);
					
					if( resposta == JOptionPane.YES_OPTION ){
						// linha válida
						Integer mat =(Integer) table.getValueAt(selectedIndex, 0);
						
						// cria  controlador
						AlunoControle controle = new AlunoControle();
						// busca o aluno pelo id
						Aluno a =(Aluno) controle.buscaPorId(mat);
						controle.remover(a);
						populaTabela();
					}
					
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl)
								.addComponent(lblEmail)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblDataNasc))
								.addComponent(lblTurma, Alignment.TRAILING))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbTurma, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jtfEmail)
										.addComponent(jtfNome)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jtfData)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(btnGravar))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnExcluir)))))
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
							.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(btnGravar)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDataNasc)
							.addGap(18)
							.addComponent(lblTurma))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnExcluir)
								.addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		
		table.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2){
					int linha = table.getSelectedRow();
					if(linha > -1){
						// linha válida
						Object mat =table.getValueAt(linha, 0);
						// converte para inteiro
						int numeroMatricula = (Integer) mat;
						// cria  controlador
						AlunoControle controle = new AlunoControle();
						// busca o aluno pelo id
						Aluno a =(Aluno) controle.buscaPorId(numeroMatricula);
						editarAluno(a);
					}
					
				}
			}

			
		
		} );
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Descri\u00E7\u00E3o"
			}
		){
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		});
		
		table.getColumnModel().getColumn(1).setPreferredWidth(249);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		
		btnGravar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Aluno a;
				if(alunoEmEdicao == null){
					a = new Aluno();
				}else{
					a = alunoEmEdicao;
				}
				
				a.setNome( jtfNome.getText()  );
				a.setEmail( jtfEmail.getText()  );
				
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					a.setDataNascimento( f.parse(jtfData.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Turma turmaSelecionada = (Turma) cmbTurma.getSelectedItem();
				 a.setTurma( turmaSelecionada  );
				new AlunoControle().gravar(a);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
				populaTabela();
				alunoEmEdicao = null;
				jtfNome.setText("");
				jtfEmail.setText("");
				jtfData.setText("");
				
			}
		}  );
		
	}

	private void editarAluno(Aluno a) {

		if(a != null){
			this.alunoEmEdicao = a;
			// com base nos dados do banco
			// popula a tela
			jtfEmail.setText( a.getEmail()  );
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format(a.getDataNascimento());
			jtfData.setText( data );
			jtfNome.setText(a.getNome());
			
			cmbTurma.setSelectedItem(a.getTurma());
		}
	};
	
	public static void main(String[] args) {
		new FrmAluno();
	}
}
