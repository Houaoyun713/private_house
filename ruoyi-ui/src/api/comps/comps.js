import request from '@/utils/request'

// 查询主管部门列表
export function listComps(query) {
  return request({
    url: '/comps/comps/list',
    method: 'get',
    params: query
  })
}

// 查询主管部门详细
export function getComps(id) {
  return request({
    url: '/comps/comps/' + id,
    method: 'get'
  })
}

// 新增主管部门
export function addComps(data) {
  return request({
    url: '/comps/comps',
    method: 'post',
    data: data
  })
}

// 修改主管部门
export function updateComps(data) {
  return request({
    url: '/comps/comps',
    method: 'put',
    data: data
  })
}

// 删除主管部门
export function delComps(id) {
  return request({
    url: '/comps/comps/' + id,
    method: 'delete'
  })
}
