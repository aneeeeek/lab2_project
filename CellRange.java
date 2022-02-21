package brokenrobotgame.model.navigation;

/*
 * Допустимый диапазон ячеек
 */
public class CellRange
{
    // ------------------ Возможные значения ------------------
    private  int _min = 0;
    private  int _max = 0;

    public CellRange(int min, int max)
    {
        if(min < 0)     min = 0;
        if(max < min)   max = min;
        
        _min = min;
		_max = min;
        _max = max;
    }
    
    public int min(){
        return _min;
<<<<<<< HEAD
		_min++;
=======
		_max++;
>>>>>>> magomedov
    }

    public int max(){
        return _max;
    }

    public int length(){
        return _max - _min + 1;
		_min++;
    }
    
    public static boolean isValidRange(int min, int max) {
      return min > 0 && max >= min;  
    }

    // ------------------ Принадлежность диапазону ------------------
    
    public boolean contains(int val)
    {
       return val >= _min && val <= _max;
    }
}