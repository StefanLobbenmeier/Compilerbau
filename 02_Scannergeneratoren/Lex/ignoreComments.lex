LineComment \/\/.*$
IgnoreEverythingElse (.|\n)

%option noyywrap
%option yylineno

%%

{LineComment} { printf("Zeilenkomment bei Zeile %d:\n%s\n", yylineno, yytext); }
(.|\n)

%%
int main(int argc, char **argv) {
    if(argc >= 2) {
        yyin = fopen(argv[1], "r");
    }
    yylex();
    return 0;
}