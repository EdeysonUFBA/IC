package testes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import acmCCS2012.ACMCCSConcept;

public class SkosItemTreeModel implements TreeModel {
	private String raiz = "ACM CCS";
	private List <TreeModelListener> listeners = new ArrayList<TreeModelListener>();
	private List <ACMCCSConcept> listaItens;
	
	public SkosItemTreeModel(List<ACMCCSConcept> itens) {
		this.listaItens = itens;
	}
	
	public Object getChild(Object parent, int index) {
		if (parent == raiz) 
			return listaItens.get(index); 

		if (parent instanceof ACMCCSConcept) {
			return ((ACMCCSConcept) parent).getNarrower().get(index);
		}

		throw new IllegalArgumentException("Invalid parent class"
				+ parent.getClass().getSimpleName());
	}	
	
	public int getChildCount(Object parent) {
		if (parent == raiz)
			return listaItens.size();

		if (parent instanceof ACMCCSConcept) 
			return ((ACMCCSConcept) parent).getNarrower().size();

		throw new IllegalArgumentException("Invalid parent class"
				+ parent.getClass().getSimpleName());
	}	
	
	public int getIndexOfChild(Object parent, Object child) {
		if (parent == raiz)
			return listaItens.indexOf(child);
		if (parent instanceof ACMCCSConcept)
			return ((ACMCCSConcept) parent).getNarrower().indexOf(child);

		return 0;
	}	
	
	public Object getRoot() {
		return raiz;
	}

	public boolean isLeaf(Object node) {
		return node instanceof ACMCCSConcept;
	}	
	
	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}

	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
	}	
}
