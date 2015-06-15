package res.dh;

import java.util.ArrayList;

import res.dia.Dia;
import res.dia.DiaDAO;
import res.horario.Horario;
import res.horario.HorarioDAO;

public class DHDAO {
	private DiaDAO diaDAO;
	private HorarioDAO horarioDAO;
	
	private ArrayList<DH> dhs;

	public DHDAO(DiaDAO diaDAO, HorarioDAO horarioDAO) {
		super();
		this.diaDAO = diaDAO;
		this.horarioDAO = horarioDAO;
	}
	
	public void load(){
		dhs = new ArrayList<DH>();
		for(Dia d : diaDAO.list()){
			for(Horario h : horarioDAO.list()){
				DH dh = new DH(d, h);
				dhs.add(dh);
			}
		}
	}
	
	public ArrayList<DH> list(){
		return new ArrayList<DH>(dhs);
	}
}
