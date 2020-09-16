package com.flyflyyun.tongtech;

/**
 * 冒泡排序算法
 * @author : yufeifei
 * @date :2018年11月15日 下午8:56:24
 */
public class Test5 {

	public static void main(String[] args) {
		//3,5,25,8,23,28,10,7,22,35,20
		int[] arr ={3,5,25,8,23,28,10,7,22,35,20};
		//调冒泡排序方法
		bubbleSort(arr);
	}
	
	/**
	 * 
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
     * 每一次循环都把较大的值(气泡)浮上去。(每次都确定一个相对大的值)
	 *@param:@param numbers
	 *@return:void
	 */
	 public static void bubbleSort(int[] arr){
		 	int temp=0,len = arr.length;
		 	
			for (int i=0 ; i < len-1; i++ ) {  		 //外层循环(len-1)次,
				for (int j = 0; j < len-1-i; j++) {  //外层循环n次，内层需要比较(len-n)次
						if(arr[j] > arr[j+1]){           //交换两个数的位置
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
				//外层第一次循环，找到最大的值(35)，外层第二次循环找到第二大的值(28),......，
				//外层最后一次循环,内层只比较一次，找到相对大的值arr[1]为5
				System.out.println("第"+(i+1)+"次循环找到"+arr[len-1-i]); 
			}
			
			//打印输出
			for (int i : arr) {
				System.out.print(i+"  ");
			}
	 }
}
