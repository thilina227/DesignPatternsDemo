package designpatternsdemo.state;

public class Client {
    public static void main(String[] args) {
        Assignment assignment = new Assignment(Assignment.inProgress);
        assignment.attempt();
        assignment.mark();
        
        assignment.submit();
        assignment.attempt();
        assignment.mark();
        
        assignment.attempt();
        assignment.submit();
        assignment.mark();
       
    }
}

interface AssignmentState {
   void attemptAssignment(Assignment assignment);
   void submitAssignment(Assignment assignment);
   void markAssignment(Assignment assignment);
}

class InProgress implements AssignmentState {
  
    @Override
    public void attemptAssignment(Assignment assignment) {
        System.out.println("Assignment is in-progress");
    }

    @Override
    public void submitAssignment(Assignment assignment) {
        System.out.println("Assignment submitted");
        assignment.setState(Assignment.submitted);
    }

    @Override
    public void markAssignment(Assignment assignment) {
        System.out.println("Assignment is still not submitted,"
                + " cannot mark yet!");
    }    
}

class Submitted implements AssignmentState {
   
    @Override
    public void attemptAssignment(Assignment assignment) {
        System.out.println("Assignment is already submitted!");
    }

    @Override
    public void submitAssignment(Assignment assignment) {
        System.out.println("Assignment submitted");
    }

    @Override
    public void markAssignment(Assignment assignment) {
        System.out.println("Assignment is marked!");
        assignment.setState(Assignment.marked);
    }    
}

class Marked implements AssignmentState {
    
    @Override
    public void attemptAssignment(Assignment assignment) {
        System.out.println("Assignment is already marked!");
    }

    @Override
    public void submitAssignment(Assignment assignment) {
        System.out.println("Assignment is already marked!");
    }

    @Override
    public void markAssignment(Assignment assignment) {
        System.out.println("Assignment is already marked!");
    }    
}

class Assignment{
   private AssignmentState currentState;
   
   public final static AssignmentState inProgress = new InProgress();
   public final static AssignmentState submitted = new Submitted();
   public final static AssignmentState marked = new Marked();

   public Assignment(AssignmentState currentState) {
       this.currentState = currentState;
   }
   public void setState(AssignmentState state){
      this.currentState = state;		
   }

   public AssignmentState getState(){
      return currentState;
   }
   
   public void attempt(){
       currentState.attemptAssignment(this);
   }
   public void submit(){
       currentState.submitAssignment(this);
   }
   public void mark(){
       currentState.markAssignment(this);
   }
}