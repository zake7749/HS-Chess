分工表
===========

版面配置
-----------

1. 繪圖：

	* 棋盤繪圖 : Done.
	* 棋子繪圖 :
	* 棋子選擇highlight：

2. Swing 排版 ：

	* UI 設計 ： Button or menubar for new game,surrender...etc.
	* AI groupBox :

程式部分
-----------

1. 棋子走法限制(Chess.java(abstract))：

	* 定義所有棋路走法

2. 遊戲主控(Game.java)：

	* 判斷新遊戲開始
	* 判斷遊戲結束
	* 判斷悔棋
	* 判斷選擇範圍是否有棋子
	* 判斷棋子是否可選
	* 高亮當前棋子
	* 判斷當前步法是否可行
	* 判斷高階組合步法(e.g 吃過路兵)
	* 移動棋子
	* 判斷玩家轉換

3. AI：

程式架構
-----------

1.Game.java

		遊戲主控器，透過一個狀態機對讀入操作進行轉換。此部分囊括了Swing的UI設計、棋盤貼圖等等。
		基礎架構：
			一個棋盤矩陣 - 紀錄我方棋子位置、敵方旗子位置
			若干個Chess的實例
			滑鼠監聽器
			新遊戲、結束遊戲、玩家操作......轉換之狀態機
			AI操作

2.Chess.java

		抽象類別，定義一個棋子的普騙行為
		繼承上修改的member：
		boolean critical - 失去這個棋子是否會導致遊戲結束
		int weight - 該棋之權重，用於AI操作
		抽象方法：
		boolean[][] getReachableGrid(Chess[][]):讀入棋盤，回傳該棋子可走至的所有區塊
		boolean isReachable(int,int,Chess[][]):讀入棋盤，判斷可否達到輸入點

3.XXXChess.java

		is a Chess.
		因應各個棋子的走法定義Chess的抽象method.
