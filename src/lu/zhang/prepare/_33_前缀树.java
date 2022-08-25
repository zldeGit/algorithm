package lu.zhang.prepare;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张璐
 * @date 2022/3/28
 */
public class _33_前缀树 {
	public static class TrieTree{
		public TrieTree[] node;
		public int pass;
		public int end;


		public TrieTree() {
			node = new TrieTree[26];
		}
		public TrieTree(String s) {
			node = new TrieTree[26];
			this.add(s);
		}
		public TrieTree(List<String> sts) {
			node = new TrieTree[26];
			for (int i = 0; i < sts.size(); i++) {
				this.add(sts.get(i));
			}
		}
		public void add(String s){
			if (s == null||s.length()==0) {
				return;
			}
			TrieTree cur = this;
			cur.pass++;
			for (int i = 0; i < s.length(); i++) {
				int i1 = s.charAt(i) - 'a';
				if (cur.node[i1] == null) {
					TrieTree trieTree = new TrieTree();
					cur.node[i1]= trieTree;
				}
				cur = cur.node[i1];
				cur.pass++;
			}
			cur.end++;
		}

		public boolean startWith(String s) {
			if (s == null || s.length() == 0) {
				return false;
			}
			TrieTree cur =this;
			for (int i = 0; i < s.length(); i++) {
				TrieTree trieTree = cur.node[s.charAt(i)-'a'];
				if (trieTree == null||trieTree.pass==0) {
					return false;
				}
				cur = trieTree;
			}
			return true;
		}

		public boolean remove(String s) {
			if (!startWith(s)) {
				return false;
			}
			TrieTree cur = this;
			for (int i = 0; i < s.length(); i++) {
				TrieTree trieTree =cur.node[s.charAt(i)-'a'];
				if (trieTree.pass > 1) {
					trieTree.pass--;
				} else {
					cur.node[s.charAt(i) - 'a'] = null;
					return true;
				}
				cur = trieTree;
			}
			cur.end--;
			return true;
		}
	}

	public static void main(String[] args) {
		TrieTree trieTree = new TrieTree(Arrays.asList("asdf", "asdasdaasdfgasd", "asdaqasdfasdf", "asdaqwaasd"));
		trieTree.remove("asdf");
		System.out.println(trieTree.startWith("asdf"));
	}
}
