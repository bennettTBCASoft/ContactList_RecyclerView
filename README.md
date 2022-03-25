# 連絡人清單 - RecyclerView

## 先上成果
![](https://i.imgur.com/nxBc9xV.gif)


## 完整程式碼
1. 建立新的資料類別（MainActivity.kt）
![](https://i.imgur.com/0XY16nX.png)

2. 開啟 **MyAdapter** 檔，繼承 **RecyclerView.Adapter**，建立 **ViewHolder類別**，使其繼承**RecyclerView.ViewHolder**，並撰寫客製化程式碼
![](https://i.imgur.com/p8N8YBb.png)
 - class ViewHolder(v:View): RecyclerView.ViewHolder(v){}
     - item component 在這裏宣告
 - getItemCount()
 - onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder{}
     - item 的 layout 在這裡載入
 - onBindViewHolder(holder: ViewHolder, position: Int){}
     - item 的 data 在這裡載入 & 監聽在這實作

3. MainActivity.kt 接收回傳資料
![](https://i.imgur.com/APZEph6.png)
 - 可參考：[返回資料至上一個畫面](https://hackmd.io/OCASdzU3SMyUjEL5N5pohg)
 
4. 設定 **Recycler** 佈局 (MainActivity -> onCreate())
![](https://i.imgur.com/mBmu3IE.png)
 - linearLayoutManager 設定(orientation)
 - recyclerView.layoutManager

5. 連接 Adapter
![](https://i.imgur.com/QmZasLi.png)

6. 跳轉下一頁，用 Launch 取代 startActivity
![](https://i.imgur.com/NKk5SF0.png)

7. MainActivity2
![](https://i.imgur.com/osXGPp1.png)
 - 用 bundle 打包，putString("key", "value")
 - setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
 - finish()
###### tags: `kotlin` `recyclerView`
