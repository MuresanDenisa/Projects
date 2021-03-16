----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/02/2020 04:00:06 PM
-- Design Name: 
-- Module Name: sumADDN - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity sumADDN is
Generic (n: natural);
Port ( X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
       S: out STD_LOGIC_VECTOR(n-1 downto 0);
       Tin: in STD_LOGIC;
       Tout: out STD_LOGIC);
end sumADDN;

architecture Behavioral of sumADDN is

begin
process(X,Y,Tin)
variable Taux:STD_LOGIC_VECTOR(n downto 0);
    begin
        Taux(0) := Tin;
		for i in 0 to n-1 loop
			S(i) <= X(i) xor Y(i) xor Taux(i);
			Taux(i+1) := (X(i) and Y(i)) or ((X(i) or Y(i)) and Taux(i));
		end loop;
		Tout<=Taux(n);
end process;

end Behavioral;
