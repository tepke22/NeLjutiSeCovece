
public class Polje {

	private int x;
	private int y;
	private int zauzeto;
	private Pijun zauzeo;
	
	public Polje(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.zauzeto = 0;
		this.zauzeo = null;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZauzeto() {
		return zauzeto;
	}

	public void setZauzeto(int zauzeto) {
		this.zauzeto = zauzeto;
	}

	public Pijun getZauzeo() {
		return zauzeo;
	}

	public void setZauzeo(Pijun zauzeo) {
		this.zauzeo = zauzeo;
	}
	
	public void setPolje(Polje a) 
	{
		this.x = a.getX();
		this.y = a.getY();
	}

	@Override
	public String toString() {
		return "Polje [x=" + x + ", y=" + y + ", zauzeto=" + zauzeto + ", zauzeo=" + zauzeo + "]";
	}
	
	
	
}
