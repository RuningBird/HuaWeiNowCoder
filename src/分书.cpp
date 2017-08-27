#include <iostream>
#include <conio.h>
using namespace std;

int like[5][5] = {
	{ 0,0,1,1,0 },
	{ 1,1,0,0,1 },
	{ 0,1,1,0,1 },
	{ 0,0,0,1,0 },
	{ 0,1,0,0,1 } };

int take[5] = { 0,0,0,0,0 };//记录每一本书的分配情况
int n;//n表示分书方案数
void trynext(int i);

int main()
{
	n = 0;
	trynext(0);
	getch();
	return 0;
}

//对第 i 个人进行分配
void trynext(int i)
{
	int j, k;
	for (j = 0; j < 5; j++)
	{
		if (like[i][j] && take[j] == 0)
		{
			take[j] = i + 1;//把第j本书分配给第i个人
			if (i == 4)//第5个人分配结束，也即所有的书已经分配完毕，可以将方案进行输出
			{
				n++;
				cout << "第" << n << "种分配方案" << endl;
				for (k = 0; k < 5; k++)
					cout << "第" << k << "本书分配给" << (char)(take[k] + 'A' - 1) << endl;
				cout << endl;
			}
			else
				trynext(i + 1);//递归，对下一个人进行分配
			take[j] = 0;//回溯，寻找下一种方案
		}
	}
}

