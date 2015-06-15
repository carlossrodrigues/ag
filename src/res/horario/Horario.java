package res.horario;

public class Horario {
	private int id;
	private String desc;
	public Horario(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
}
