package mymaths;

/**
 * myTmpl
 */
class myTmpl implements myInterface{
    @Override
    public int getMax(int a,int b,int c){
        if (a >b){
            return a>c?a:c;
        }else{
            return b>c?b:c;
        }
    }

    @Override
    public int getMin(int a,int b,int c){
        if (a < b){
            return a<c?a:c;
        }else{
            return b<c?b:c;
        }
        
    }
}