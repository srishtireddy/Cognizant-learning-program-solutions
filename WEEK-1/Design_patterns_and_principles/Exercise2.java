// Implementing the Factory Method Pattern
interface Document {
    void open();
    void save();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }
    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
    @Override
    public void close() {
        System.out.println("Closing Word document");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }
    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document");
    }
    @Override
    public void save() {
        System.out.println("Saving Excel document");
    }
    @Override
    public void close() {
        System.out.println("Closing Excel document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}


public class Exercise2 {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}

/*
 *  Output:
 *  Opening Word document
 *  Saving Word document
 *  Closing Word document
 *  Opening PDF document
 *  Saving PDF document
 *  Closing PDF document
 *  Opening Excel document
 *  Saving Excel document
 *  Closing Excel document
 */