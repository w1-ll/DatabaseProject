
public class TreeIdentifier {
	protected int unique_id;
	protected int tree_ids;
	
	TreeIdentifier(){
		
	}
	TreeIdentifier(int unique_id){
		this.unique_id = unique_id;
	}
	TreeIdentifier(int unique_id, int tree_ids){
		this.unique_id = unique_id;
		this.tree_ids = tree_ids;
	}
	
	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}
	public void setTree_ids(int tree_ids) {
		this.tree_ids = tree_ids;
	}
	public int getUnique_id() {
		return unique_id;
	}
	public int getTree_ids() {
		return tree_ids;
	}

}
