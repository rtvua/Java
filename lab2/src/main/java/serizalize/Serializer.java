package serizalize;

import lab2.*;

import java.io.IOException;

public interface Serializer {
    String toJsonString();
    Person fromJsonString(String string);
    void toJsonFile();
    Person fromJsonFile(String filename);
    String toXmlString();
    Person fromXmlString(String string);
    void toXmlFile();
    Person fromXmlFile(String filename);
    String toTextString();
    Person fromTextString(String string);
    void toTextFile();
    Person fromTextFile(String filename);
}
