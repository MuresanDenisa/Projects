----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/28/2020 05:23:33 PM
-- Design Name: 
-- Module Name: digitDividerBy2 - Behavioral
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

entity digitDividerBy2 is
Port ( 
X: in STD_LOGIC_VECTOR(3 downto 0);
Y: in STD_LOGIC_VECTOR(3 downto 0);
C: out STD_LOGIC_VECTOR(3 downto 0));
end digitDividerBy2;

architecture Behavioral of digitDividerBy2 is

begin
process (X,Y)
begin
    if ( Y="0001" or Y="0011"  or Y="0101" or Y="0111" or Y="1001") then
                case X is
                    when "0000" => C<="0101";--0
                    when "0001" => C<= "0101"; --1
                    when "0010" => C<= "0110"; --2
                    when "0011" => C<= "0110"; --3
                    when "0100" => C<= "0111"; --4
                    when "0101" => C<= "0111"; --5
                    when "0110" => C<= "1000"; --6
                    when "0111" => C<= "1000"; --7
                    when "1000" => C<= "1001"; --8
                    when "1001" => C<= "1001"; --9
                    when others => C<= "0000"; -- others
                end case;
            else
                case X is
                    when "0001" => C<= "0000"; --1
                    when "0010" => C<= "0001"; --2
                    when "0011" => C<= "0001"; --3
                    when "0100" => C<= "0010"; --4
                    when "0101" => C<= "0010"; --5
                    when "0110" => C<= "0011"; --6
                    when "0111" => C<= "0011"; --7
                    when "1000" => C<= "0100"; --8
                    when "1001" => C<= "0100"; --9
                    when others => C<= "0000"; -- others
                end case;
            end if;
end process;
end Behavioral;
