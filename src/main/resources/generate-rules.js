importPackage(java.lang);
importPackage(java.io);
importPackage(java.nio.file);
System.out.println("AAA" + project.getName());
const resourcesPath = "src/main/resources";
const rulebookPath = "rulebook/dnd-5e-srd";
const rulebookFiles = ["00-legal.json"];
var legal;
rulebookFiles.forEach(function (rulebookFile) {
    var filePath = resourcesPath + "/" + rulebookPath + "/" + rulebookFile;
    System.out.println("Reading file \"" + filePath + "\".");
    //const jsonString = String.join(",", Files.readAllLines(Paths.get(filePath)));

    //System.out.println(jsonString);
    //legal = JSON.parse(jsonString);
});
