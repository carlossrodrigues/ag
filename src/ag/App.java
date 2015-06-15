package ag;

import java.util.ArrayList;

import res.conexao.ConnectionFactory;
import res.dh.DH;
import res.dh.DHDAO;
import res.dia.Dia;
import res.dia.DiaDAO;
import res.disciplinas.DisciplinaDAO;
import res.dp.DP;
import res.dp.DPDAO;
import res.horario.Horario;
import res.horario.HorarioDAO;
import res.prioridade.PrioridadeDAO;
import res.professor.ProfessorDAO;
import ag.entity.Celula;

public class App {
	
	private static DiaDAO diaDAO;
	private static ProfessorDAO professorDAO;
	private static PrioridadeDAO prioridadeDAO;
	private static DisciplinaDAO disciplinaDAO;
	private static HorarioDAO horarioDAO;
	private static DPDAO dpDAO;
	private static DHDAO dhDAO;
	
	public static void main(String[] args){
		setup();
		
		ArrayList<Celula> gene = geraGene();
		
		exibeGene(gene);
	}
	
	private static void exibeGene(ArrayList<Celula> gene){
		ArrayList<Dia> dias = diaDAO.list();
		ArrayList<Horario> horarios = horarioDAO.list();
		
		Object[][] mat = new Object[horarios.size()][dias.size()];
		
		for(Celula c : gene){
			int i = horarios.indexOf(c.getDH().getHorario());
			int j = dias.indexOf(c.getDH().getDia());
			
			mat[i][j] = c.getDP().getDisciplina().getNome()+" - "+c.getDP().getProfessor().getNome();
		}
		
		ArrayList<String> head = new ArrayList<String>();
		for(Dia d : dias){
			head.add(d.getDesc());
		}
		
		TableFrame tf = new TableFrame(head.toArray(), mat);
		
		tf.setVisible(true);
	}
	
	private static ArrayList<Celula> geraGene(){
		ArrayList<DP> disciplinasProfessores = dpDAO.list();
		ArrayList<DH> diasHorarios = dhDAO.list();
		
		ArrayList<Celula> gene = new ArrayList<Celula>();
		
		while(!disciplinasProfessores.isEmpty()){
			DP dp;
			DH dh;
			
			{
				int index = (int)(Math.random()*disciplinasProfessores.size());
				
				dp = disciplinasProfessores.get(index);
				
				disciplinasProfessores.remove(index);
			}
			
			{
				int index = (int)(Math.random()*diasHorarios.size());
				
				dh = diasHorarios.get(index);
				
				diasHorarios.remove(index);
			}
			
			Celula cel = new Celula(dp, dh);
			
			gene.add(cel);
		}
		
		return gene;
	}

	private static void setup(){
		ConnectionFactory.open();
		
		diaDAO = new DiaDAO();
		diaDAO.load();
		System.out.println(diaDAO.list());
		
		professorDAO = new ProfessorDAO();
		professorDAO.load();
		System.out.println(professorDAO.list());
		
		prioridadeDAO = new PrioridadeDAO(professorDAO, diaDAO);
		prioridadeDAO.load();
		System.out.println(prioridadeDAO.list());
		
		disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.load();
		System.out.println(disciplinaDAO.list());
		
		horarioDAO = new HorarioDAO();
		horarioDAO.load();
		System.out.println(horarioDAO.list());
		
		dpDAO = new DPDAO(disciplinaDAO, professorDAO);
		dpDAO.load();
		System.out.println(dpDAO.list());
		
		dhDAO = new DHDAO(diaDAO, horarioDAO);
		dhDAO.load();
		System.out.println(dhDAO.list());
		
		ConnectionFactory.close();
	}
}