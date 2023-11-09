public class tree 
{
		protected String tree_distance;
	 	protected String trunk_size;
	    protected String tree_height;
	    protected String tree_location;
	 
	    //constructors
	    public tree() {
	    }
	 
	    public tree(String tree_distance) 
	    {
	        this.tree_distance = tree_distance;
	    }
	    
	    public tree(String tree_distance, String trunk_size, String tree_height, String tree_location) 
	    {
	    	this(trunk_size,tree_height, tree_location);
	    	this.tree_distance = tree_distance;
	    }
	 
	
	    public tree(String trunk_size, String tree_height, String tree_location) 
	    {
	    	this.trunk_size = trunk_size;
	    	this.tree_height = tree_height;
	    	this.tree_location = tree_location;
	    }
	    
	   //getter and setter methods
	    public String getTree_distance() {
	        return tree_distance;
	    }
	    public void setTree_distance(String tree_distance) {
	        this.tree_distance = tree_distance;
	    }
	    
	    public String getTrunk_size() {
	        return trunk_size;
	    }
	    public void setTrunk_size(String trunk_size) {
	        this.trunk_size = trunk_size;
	    }
	    
	    public String getTree_height() {
	        return tree_height;
	    }
	    public void setTree_height(String tree_height) {
	        this.tree_height = tree_height;
	    }
	        
	    	    
	    public String getTree_location() {
	        return tree_location;
	    }
	    public void setFinal_price(String tree_location) {
	        this.tree_location = tree_location;
	    }
	}

