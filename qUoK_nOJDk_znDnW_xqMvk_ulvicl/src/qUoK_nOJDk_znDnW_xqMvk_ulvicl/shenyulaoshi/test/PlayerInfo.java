package qUoK_nOJDk_znDnW_xqMvk_ulvicl.shenyulaoshi.test;

public class PlayerInfo {
	private int id;
	private String moveCode;//L45_45E80_-80_ST1_ET5
	private boolean into;
	private boolean leave;

	public PlayerInfo(int id, String moveCode) {
		this.id = id;
		this.moveCode = moveCode;
	}

	public String getMoveCode() {
		return moveCode;
	}

	public void setMoveCode(String moveCode) {
		this.moveCode = moveCode;
	}
	
	public static String makeMoveCode(int sx, int sy, int ex, int ey, long st, long se) {
		return "LXY"+sx+"_"+sy+"EXY"+ex+"_"+ey+"ST"+st+"ET"+se;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLeave() {
		return leave;
	}

	public void setLeave(boolean leave) {
		this.leave = leave;
	}

	public boolean isInto() {
		return into;
	}

	public void setInto(boolean into) {
		this.into = into;
	}
	

}
