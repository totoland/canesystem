package geotransform.datum;

import geotransform.coords.Gcc_Coord_3d;

public class Datum {
    public String name;
    public double	dx;
    public double	dy;
    public double	dz;

    public Datum(String eName, double x, double y, double z)
    {
        name = eName;
        dx = x;
        dy = y;
        dz = z;
        //System.out.println(name);
    }


    public static void Convert(Datum myDatum,boolean direct,Gcc_Coord_3d gcc_coord_3d_in, Gcc_Coord_3d gcc_coord_3d_out)
    {
        Gcc_Coord_3d agcc_coord_3d_in[] = new Gcc_Coord_3d[1];
        Gcc_Coord_3d agcc_coord_3d_out[] = new Gcc_Coord_3d[1];
        agcc_coord_3d_in[0] = gcc_coord_3d_in;
        agcc_coord_3d_out[0] = gcc_coord_3d_out;
        Convert(myDatum,direct,agcc_coord_3d_in, agcc_coord_3d_out);
    }


     public static void Convert(Datum myDatum,boolean direct,Gcc_Coord_3d agcc_coord_3d_in[], Gcc_Coord_3d agcc_coord_3d_out[])
    {
        if (direct)
        {
          for(int i = 0; i < agcc_coord_3d_in.length; i++)
          {
              agcc_coord_3d_out[i].x = agcc_coord_3d_in[i].x-myDatum.dx;
              agcc_coord_3d_out[i].y = agcc_coord_3d_in[i].y-myDatum.dy;
              agcc_coord_3d_out[i].z = agcc_coord_3d_in[i].z-myDatum.dz;
          }
        }
        else
        {
          for(int i = 0; i < agcc_coord_3d_in.length; i++)
          {
              agcc_coord_3d_out[i].x = agcc_coord_3d_in[i].x+myDatum.dx;
              agcc_coord_3d_out[i].y = agcc_coord_3d_in[i].y+myDatum.dy;
              agcc_coord_3d_out[i].z = agcc_coord_3d_in[i].z+myDatum.dz;
          }
        }

    }

    public Datum()
    {
    }

}