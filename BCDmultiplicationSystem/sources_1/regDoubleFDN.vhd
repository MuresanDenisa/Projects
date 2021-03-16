----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/28/2020 01:07:15 AM
-- Design Name: 
-- Module Name: regDoubleFDN - Behavioral
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

entity regDoubleFDN is
Generic (n: natural);
Port ( D1, D2: in STD_LOGIC_VECTOR(n-1 downto 0);
       outQ: out STD_LOGIC_VECTOR(n-1 downto 0);
       Clk, CE1, CE2, RST: in STD_LOGIC );
end regDoubleFDN;

architecture Behavioral of regDoubleFDN is
signal enable: STD_LOGIC_VECTOR(1 downto 0):= "00";
begin
enable<= CE1&CE2;
process (Clk)
    begin
        if(rising_edge(Clk)) then
            if(RST='1') then
                 outQ<= (others => '0');
            else
                case enable is
                    when "10" => outQ<=D1;
                    when "01" => outQ<=D2;
                    when others =>
                end case;
            end if;
         end if;
end process;

end Behavioral;
