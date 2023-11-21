public class tree 
{
		protected int tree_distance;
	 	protected int trunk_size;
	    protected int tree_height;
	    protected int tree_location;
	    protected int tree_id;
	    //constructors
	    public tree() {
	    }
	 
	    public tree(int tree_distance) 
	    {
	        this.tree_distance = tree_distance;
	    }
	    
	    public tree(int tree_distance, int trunk_size, int tree_height, int tree_location) 
	    {
	    	this(trunk_size,tree_height, tree_location);
	    	this.tree_distance = tree_distance;
	    }
	 
	
	    public tree(int trunk_size, int tree_height, int tree_location) 
	    {
	    	this.trunk_size = trunk_size;
	    	this.tree_height = tree_height;
	    	this.tree_location = tree_location;
	    }
	    
	   //getter and setter methods
	    public int getTree_distance() {
	        return tree_distance;
	    }
	    public void setTree_distance(int tree_distance) {
	        this.tree_distance = tree_distance;
	    }
	    
	    public int getTrunk_size() {
	        return trunk_size;
	    }
	    public void setTrunk_size(int trunk_size) {
	        this.trunk_size = trunk_size;
	    }
	    
	    public int getTree_height() {
	        return tree_height;
	    }
	    public void setTree_height(int tree_height) {
	        this.tree_height = tree_height;
	    }
	        
	    	    
	    public int getTree_location() {
	        return tree_location;
	    }
	    public void setTree_location(int tree_location) {
	        this.tree_location = tree_location;
	    }
	    public int getTree_id() {
	        return tree_id;
	    }
	}
