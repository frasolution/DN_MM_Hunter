#include <stdio.h>
int main(int argc, char const *argv[])
{
    printf("INFO: COMPILING SRC\n");
    system("cd src");
    system("javac *.java");
    printf("INFO: COMPILING MAIN PACKAGE FOLDER\n");
    system("cd ..");
    system("javac *.java");
    printf("INFO: EXIT CODE 0 / SUCCSSESS\n");
    return 0;
}
