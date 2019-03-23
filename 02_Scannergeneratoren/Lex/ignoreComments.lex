Comment \/\/[^$]*

%option noyywrap
%option yylineno

%%

{Comment} { printf("Zeilenkomment bei Zeile %d:\n%s\n", yylineno, yytext); }

%%

int main(int argc, char **argv) {

    yylex();
    return 0;
}