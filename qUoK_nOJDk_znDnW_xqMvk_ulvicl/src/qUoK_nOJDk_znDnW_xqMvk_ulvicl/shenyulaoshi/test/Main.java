package qUoK_nOJDk_znDnW_xqMvk_ulvicl.shenyulaoshi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//实验目的主要是命令行式输入轨迹,与实际代码无关
public class Main {
	static Random random = new Random();
	static List<PlayerInfo> playerList = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		init();
		
		run();
	}
	static long stime = 0;
	static long ctime = 0;
	private static void run() throws InterruptedException {
		stime = System.currentTimeMillis();
		
		while(true) {
			for (PlayerInfo player:playerList) {
				ctime = currenttime();
				if(!player.isInto() &&ctime>=(long)moveCode2Obj(player.getMoveCode(), "ST") && ctime<(long)moveCode2Obj(player.getMoveCode(), "ET")) {
					ToString.println("入场", player.getId(), player.getMoveCode());
					player.setInto(true);
				}
				if(!player.isLeave() &&  ctime>=(long)moveCode2Obj(player.getMoveCode(), "ET")) {
					ToString.println("离场", player.getId(), player.getMoveCode());
					player.setLeave(true);
				}
			}
			
			Thread.sleep(100);
		}
//		for (PlayerInfo str:playerList) {
//			playerList.add(new PlayerInfo(str));
//		}
		
	}
	private static long currenttime() {
		return System.currentTimeMillis()-stime;
	}

	static void init(){
//		PlayerInfo playerInfo = new PlayerInfo();
//		playerInfo.setMoveCode("L45_45E80_-80_ST1_ET5");
		
//		PlayerInfo.makeMoveCode(45, 45, -80, 80, 1, 5);
//		playerList.add(new PlayerInfo("L45_45E80_-80_ST1_ET5"));
//		playerList.add(new PlayerInfo("L45_45E80_-80_ST1_ET5"));
//		playerList.add(new PlayerInfo("L45_45E80_-80_ST1_ET5"));
//		playerList.add(new PlayerInfo("L45_45E80_-80_ST1_ET5"));
//		playerList.add(new PlayerInfo("L45_45E80_-80_ST1_ET5"));
		
//		List<String> codelist = makeMoveMode(MoveType.MODE_1, 45, 45, 50, 0, 5, 1000, 5000, 800, -1);
		
		newPPPP(makeMoveMode(MoveType.MODE_1, 45, 45, 50, 0, 5, 1000, 5000, 800, -1));
		newPPPP(makeMoveMode(MoveType.MODE_1, 45, 45, 50, 0, 3, 4*1000, 10*1000, 800, -1));
		newPPPP(makeMoveMode(MoveType.MODE_1, 45, 45, 50, 0, 5, 8*1000, 14*1000, 800, -1));
	}
	private static void newPPPP(List<String> codelist) {
		for (String str:codelist) {
			playerList.add( new PlayerInfo(random.nextInt(999999999), str));
		}
	}
	
	/**
	 * 
	 * @param MoveType
	 * @param x
	 * @param y
	 * @param num
	 * @param leftRight -1left 1right
	 */
	static List<String> makeMoveMode(MoveType MoveType, int x, int y, int gapx, int gapy, int num, long st, long se, long gaptime, int leftRight){
		List<String> list = new ArrayList<>();
		switch (MoveType) {
		case MODE_1:
			for (int i = 0; i < num; i++) {
				String code = PlayerInfo.makeMoveCode(x+gapx*i, y+gapy*i, leftRight*80, y+80, st+gaptime*i, se+gaptime*i);
				list.add(code);
//				moveCode2Obj(code);
			}
//			PlayerInfo.makeMoveCode(45, 45, -80, 80, 1, 5);
			break;
		default:
			break;
		}
		return list;
	}
	public static String makeMoveCode(int sx, int sy, int ex, int ey, long st, long se) {
		return "L"+sx+"_"+sy+"E"+ex+"_"+ey+"ST"+st+"ET"+se;
	}
	public static Object moveCode2Obj(String code, String para) {
		Pattern emailPattern = Pattern.compile("(?<=LXY).+(?=EXY)");
        Matcher matcher = emailPattern.matcher(code);
        matcher.find();
        String[] xy = matcher.group().split("_");
        int sx = Integer.parseInt(xy[0]);
        int sy = Integer.parseInt(xy[1]);
    	emailPattern = Pattern.compile("(?<=EXY).+(?=ST)");
        matcher = emailPattern.matcher(code);
        matcher.find();
        String[] exy = matcher.group().split("_");
        int ex = Integer.parseInt(exy[0]);
        int ey = Integer.parseInt(exy[1]);
        
        switch (para) {
        case "ST":
        	emailPattern = Pattern.compile("(?<=ST).+(?=ET)");
            matcher = emailPattern.matcher(code);
            matcher.find();
            long st = Integer.parseInt(matcher.group());
            return st;
		case "ET":
			emailPattern = Pattern.compile("(?<=ET).+");
	        matcher = emailPattern.matcher(code);
	        matcher.find();
	        long et = Integer.parseInt(matcher.group());
			return et;
		default:
			break;
		}
        
        return "";
//        "L45_45E80_-80_ST1_ET5"
//		return "L"+sx+"_"+sy+"E"+ex+"_"+ey+"ST"+st+"ET"+se;
	}
	
	
}
