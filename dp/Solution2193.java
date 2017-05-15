package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �� ���� ������ �ڿ� 0�� �߰� �ϴ� ����,1�� �߰� �ϴ� 2���� ��찡 ����
 * 0�� �߰� �ϴ� ���� �ٷ� ���� dp���� �״�� �����ָ� �ǰ� 1�� �߰� �ϴ� ����
 * ������ ������ 0���� ������ ����ε� ������ ������ 0���� ������ ���� �� ���� ���� ���̴�
 * d[i-1] + d[i-2]�� ���ָ� �� �ᱹ�� �Ǻ���ġ��
 */
public class Solution2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[1000001];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i=3;i<=n;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}

}
