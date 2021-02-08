package designpatternsdemo.memento;


public class Client {
    public static void main(String[] args) {
        Document article = new Document("My Article");
        article.setContent("ABCDEF");
        System.out.println(article);
//         
        DocumentMemento memento = article.createMemento();  
//         
        article.setContent("PQRSTU");      
        System.out.println(article);
//         
        article.restore(memento);       
        System.out.println(article);   
    }
}


class Document {
    private String title;
    private String content;
     
    public Document(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public DocumentMemento createMemento() {
        DocumentMemento m = new DocumentMemento(title, content);
        return m;
    }
     
    public void restore(DocumentMemento m) {
        this.title = m.getTitle();
        this.content = m.getContent();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Document{")
                .append("title=")
                .append(title)
                .append(", content=")
                .append(content).
                append('}').toString();
    }

    
}


class DocumentMemento {
    private final String title;
    private final String content;
     
    public DocumentMemento(String title, String content) {
        this.title = title;
        this.content = content;
    }
 
    public String getTitle() {
        return title;
    }
 
    public String getContent() {
        return content;
    }
}