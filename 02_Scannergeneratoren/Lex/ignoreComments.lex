LineComment \/\/.*$
BlockComment (\/\*)([^*]+|(\*[^\/]))*(\*\/)
IgnoreEverythingElse (.|\n)

%option noyywrap
%option yylineno

%%

{LineComment} { printf("Zeilenkommentar bei Zeile %d:\n%s\n", yylineno, yytext); }
{BlockComment} { printf("Blockkommentar bei Zeile %d:\n%s\n", yylineno, yytext); }
{IgnoreEverythingElse}

%%
int main(int argc, char **argv) {
    if(argc >= 2) {
        yyin = fopen(argv[1], "r");
    }
    yylex();
    return 0;
}