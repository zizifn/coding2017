package com.coderising.array;

public class ArrayUtil
{

	/**
	 * 给定一个整形数组a , 对该数组的值进行置换 例如： a = [7, 9 , 30, 3] , 置换后为 [3, 30, 9,7] 如果 a =
	 * [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * 
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin)
	{
		if (isEmpty(origin))
		{
			return;
		}
		int length = origin.length;
		for (int i = 0, j = length - 1; i < j; i++, j--)
		{
			int tmp = origin[i];
			origin[i] = origin[j];
			origin[j] = tmp;
		}
	}

	/**
	 * 现在有如下的一个数组： int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为： {1,3,4,5,6,6,5,4,7,6,7,5}
	 * 
	 * @param oldArray
	 * @return
	 */

	public int[] removeZero(int[] oldArray)
	{
		if (isEmpty(oldArray))
		{
			return oldArray;
		}
		int length = oldArray.length;
		int j = 0;
		int[] tmp = new int[length];
		for (int i = 0; i < length; i++)
		{
			if (oldArray[i] != 0)
			{
				tmp[j++] = oldArray[i];
			}
		}

		if (j == length)
		{
			return oldArray;
		} else
		{
			int[] rt = new int[j];
			System.arraycopy(tmp, 0, rt, 0, j);
			return rt;
		}

	}

	private boolean isEmpty(int[] array)
	{
		return null == array || array.length == 0;
	}

	/**
	 * 给定两个已经排序好的整形数组， a1和a2 , 创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的 例如 a1 =
	 * [3, 5, 7,8] a2 = [4, 5, 6,7] 则 a3 为[3,4,5,6,7,8] , 注意： 已经消除了重复
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */

	public int[] merge(int[] array1, int[] array2)
	{
		if (isEmpty(array1) && isEmpty(array2))
		{
			if (null != array1)
			{
				return array1;
			}
			return array2;
		}
		int len1 = array1.length;
		int len2 = array2.length;
		int[] tmp = new int[len1 + len2];
		int i = 0, j = 0, k = 0;
		while (i < len1 && j < len2)
		{
			//如果array1[i]已经放入了
			if(k>0 && tmp[k-1]==array1[i])
			{
				i++;
				continue;
			}
			//如果array2[j]已经放入了
			if(k>0 && tmp[k-1]==array2[j])
			{
				j++;
				continue;
			}

			if (array1[i] < array2[j])
			{
				tmp[k++] = array1[i++];
			} else if (array1[i] > array2[j])
			{
				tmp[k++] = array2[j++];
			} else
			{
				tmp[k++] = array1[i++];
				j++;
			}
		}
		// 剩余的
		while (i < len1)
		{
			//如果已经放入了
			if(k>0 && tmp[k-1]==array1[i])
			{
				i++;
				continue;
			}
			tmp[k++] = array1[i++];
		}
		while (j < len2)
		{
			//如果已经放入了
			if(k>0 && tmp[k-1]==array2[j])
			{
				j++;
				continue;
			}
			tmp[k++] = array2[j++];
		}
		if (k == len1 + len2)
		{
			return tmp;
		}
		int[] rt = new int[k];
		System.arraycopy(tmp, 0, rt, 0, k);
		return rt;
	}

	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * 
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int[] oldArray, int size)
	{
		if (size <= 0)
		{
			return oldArray;
		}
		if (isEmpty(oldArray))
		{
			return new int[size];
		}
		int length = oldArray.length;
		int[] newArray = new int[length + size];
		System.arraycopy(oldArray, 0, newArray, 0, length);
		return newArray;
	}

	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21...... ，给定一个最大值， 返回小于该值的数列 例如， max = 15 ,
	 * 则返回的数组应该为 [1，1，2，3，5，8，13] max = 1, 则返回空数组 []
	 * 
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max)
	{
		if (max <= 0)
		{
			return null;
		}
		if (max == 1)
		{
			return new int[]
			{ 1 };
		}
		if (max == 2)
		{
			return new int[]
			{ 1, 1 };
		}
		int prepre = 1;
		int pre = 1;
		int now = 0;
		int[] tmp = new int[max];
		int i = 0;
		while ((now = prepre + pre) <= max)
		{
			prepre = pre;
			pre = now;
			tmp[i++] = now;
		}
		int[] rt = new int[i + 2];
		System.arraycopy(tmp, 0, rt, 2, i);
		rt[0] = 1;
		rt[1] = 1;
		return rt;
	}

	/**
	 * 返回小于给定最大值max的所有素数数组 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * 
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max)
	{
		if (max <= 1)
		{
			return null;
		}
		int[] tmp = new int[max];
		int k = 0;
		for (int i = 2; i < max; i++)
		{
			if (isPrime(i))
			{
				tmp[k++] = i;
			}
		}
		int[] rt = new int[k];
		System.arraycopy(tmp, 0, rt, 0, k);
		return rt;
	}

	private boolean isPrime(int num)
	{
		if (num == 2)
		{
			return true;
		}
		for (int i = 2; i <= Math.sqrt(num); i++)
		{
			if (num % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * 
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max)
	{
		if (max <= 0)
		{
			return null;
		}
		int[] tmp = new int[20];
		int k = 0;
		for (int i = 1; i < max; i++)
		{
			if (isPerfectNumber(i))
			{
				tmp[k++] = i;
			}
		}
		int[] rt = new int[k];
		System.arraycopy(tmp, 0, rt, 0, k);
		return rt;
	}

	private boolean isPerfectNumber(int num)
	{
		if (num == 1)
		{
			return false;
		}
		int factorSum = 0;
		for (int i = 1; i <= num / 2; i++)
		{
			// is factor
			if (num % i == 0)
			{
				factorSum += i;
			}
		}
		return factorSum == num;
	}

	/**
	 * 用seperator 把数组 array给连接起来 例如array= [3,8,9], seperator = "-" 则返回值为"3-8-9"
	 * 
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator)
	{
		if (isEmpty(array))
		{
			return "";
		}
		int len = array.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len - 1; i++)
		{
			sb.append(array[i]);
			sb.append(seperator);
		}
		sb.append(array[len - 1]);
		return sb.toString();
	}

}
