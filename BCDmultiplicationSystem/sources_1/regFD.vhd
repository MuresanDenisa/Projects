----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/02/2020 04:02:20 PM
-- Design Name: 
-- Module Name: regFD - Behavioral
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

entity regFD is
Port ( D, Clk, CE, RST: in STD_LOGIC;
       Q: out STD_LOGIC );
end regFD;

architecture Behavioral of regFD is

begin
process (Clk)
    begin
    if(rising_edge(Clk)) then
            if(RST='1') then
                 Q<= '0';
            elsif( CE='1') then
                Q<=D;
            end if;
        end if;
end process;
end Behavioral;
