package ag;

import res.conexao.ConnectionFactory;
import res.dia.DiaDAO;
import res.disciplinas.DisciplinaDAO;
import res.horario.HorarioDAO;
import res.prioridade.PrioridadeDAO;
import res.professor.ProfessorDAO;

public class App {
	
	private static DiaDAO diaDAO;
	private static ProfessorDAO professorDAO;
	private static PrioridadeDAO prioridadeDAO;
	private static DisciplinaDAO disciplinaDAO;
	private static HorarioDAO horarioDAO;
	
	public static void main(String[] args){
		setup();
		
		System.out.println("ok");
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
		
		ConnectionFactory.close();
	}
}